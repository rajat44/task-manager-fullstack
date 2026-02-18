@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public TaskResponse create(TaskRequest request) {
        Task task = Task.builder()
                .title(request.title())
                .description(request.description())
                .isCompleted(Boolean.TRUE.equals(request.isCompleted()))
                .dueDate(request.dueDate())
                .build();

        return map(repository.save(task));
    }

    @Override
    public TaskResponse update(Long id, TaskRequest request) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setCompleted(Boolean.TRUE.equals(request.isCompleted()));
        task.setDueDate(request.dueDate());

        return map(repository.save(task));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TaskResponse getById(Long id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found")));
    }

    @Override
    public Page<TaskResponse> getAll(Boolean completed,
                                     LocalDateTime startDate,
                                     LocalDateTime endDate,
                                     Pageable pageable) {

        Specification<Task> spec = Specification.where(null);

        if (completed != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("isCompleted"), completed));
        }

        if (startDate != null && endDate != null) {
            spec = spec.and((root, query, cb) ->
                    cb.between(root.get("dueDate"), startDate, endDate));
        }

        return repository.findAll(spec, pageable)
                .map(this::map);
    }

    private TaskResponse map(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getDueDate()
        );
    }
}

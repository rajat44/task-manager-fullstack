@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    TaskRepository repository;

    @InjectMocks
    TaskServiceImpl service;

    @Test
    void shouldCreateTask() {
        TaskRequest request = new TaskRequest("Test", null, false, null);

        when(repository.save(any())).thenReturn(
                Task.builder().id(1L).title("Test").build());

        TaskResponse response = service.create(request);

        assertEquals("Test", response.title());
    }
}

import { useEffect, useState } from "react";
import { api } from "../services/api";
import { Link } from "react-router-dom";

interface Task {
  id: number;
  title: string;
  description?: string;
  isCompleted: boolean;
  dueDate?: string;
}

const TaskList = () => {
  const [tasks, setTasks] = useState<Task[]>([]);

  const fetchTasks = async () => {
    const res = await api.get("/tasks");
    setTasks(res.data.content);
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  const toggleTask = async (task: Task) => {
    await api.put(`/tasks/${task.id}`, {
      ...task,
      isCompleted: !task.isCompleted,
    });
    fetchTasks();
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Task List</h2>
      <Link to="/add">Add Task</Link>
      <hr />
      {tasks.map((task) => (
        <div key={task.id}>
          <h4>{task.title}</h4>
          <input
            type="checkbox"
            checked={task.isCompleted}
            onChange={() => toggleTask(task)}
          />
        </div>
      ))}
    </div>
  );
};

export default TaskList;

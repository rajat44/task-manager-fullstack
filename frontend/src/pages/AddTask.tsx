import { useState } from "react";
import { api } from "../services/api";
import { useNavigate } from "react-router-dom";

const AddTask = () => {
  const [title, setTitle] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    await api.post("/tasks", {
      title,
      isCompleted: false,
    });
    navigate("/");
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Add Task</h2>
      <form onSubmit={handleSubmit}>
        <input
          name="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="Task Title"
          required
        />
        <button type="submit">Save</button>
      </form>
    </div>
  );
};

export default AddTask;

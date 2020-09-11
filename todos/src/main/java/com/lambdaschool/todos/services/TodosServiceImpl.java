package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosrepos;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        Todos currentTodo = todosrepos.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo " + " Not" +
                " Found"));
        currentTodo.setCompleted(!currentTodo.isCompleted());

        todosrepos.save(currentTodo);

    }
}

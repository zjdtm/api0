package org.zerock.api0.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.zerock.api0.domain.Todo;
import org.zerock.api0.dto.PageRequestDTO;
import org.zerock.api0.dto.PageResponseDTO;
import org.zerock.api0.dto.TodoDTO;
import org.zerock.api0.repository.TodoRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(TodoDTO todoDTO) {

        Todo todo = modelMapper.map(todoDTO, Todo.class);

        Long tno = todoRepository.save(todo).getTno();

        return tno;
    }

    @Override
    public TodoDTO read(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        return modelMapper.map(todo, TodoDTO.class);

    }

    @Override
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {

        Page<TodoDTO> result = todoRepository.list(pageRequestDTO);

        return PageResponseDTO.<TodoDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(result.toList())
                .total((int)result.getTotalElements())
                .build();

    }

    @Override
    public void remove(Long tno) {
        todoRepository.deleteById(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {

        Optional<Todo> result = todoRepository.findById(todoDTO.getTno());

        Todo todo = result.orElseThrow();

        todo.changeTitle(todoDTO.getTitle());
        todo.changeDuDate(todoDTO.getDueDate());
        todo.changeComplete(todoDTO.isComplete());

        todoRepository.save(todo);
    }


}

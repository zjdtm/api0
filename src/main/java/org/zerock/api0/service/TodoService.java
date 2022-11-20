package org.zerock.api0.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.api0.dto.PageRequestDTO;
import org.zerock.api0.dto.PageResponseDTO;
import org.zerock.api0.dto.TodoDTO;

@Transactional
public interface TodoService {
    Long register(TodoDTO todoDTO);

    TodoDTO read(Long tno);

    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}

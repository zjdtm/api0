package org.zerock.api0.repository.search;

import org.springframework.data.domain.Page;
import org.zerock.api0.dto.PageRequestDTO;
import org.zerock.api0.dto.TodoDTO;

public interface TodoSearch {

    Page<TodoDTO> list(PageRequestDTO pageRequestDTO);

}

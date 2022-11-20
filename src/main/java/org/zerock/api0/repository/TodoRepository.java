package org.zerock.api0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.api0.domain.Todo;
import org.zerock.api0.repository.search.TodoSearch;

public interface TodoRepository extends JpaRepository<Todo,Long>, TodoSearch {
}

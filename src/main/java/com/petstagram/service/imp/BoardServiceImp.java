package com.petstagram.service.imp;

import com.petstagram.model.dto.BoardResponseDto;
import com.petstagram.model.dto.CreateBoardRequestDto;
import com.petstagram.model.entity.Board;
import com.petstagram.model.entity.User;
import com.petstagram.repository.BoardRepository;
import com.petstagram.repository.UserRepository;
import com.petstagram.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class BoardServiceImp implements BoardService {
    private final BoardRepository boardRepository;
   private final UserRepository userRepository;

    @Override
    public BoardResponseDto create(CreateBoardRequestDto dto,Long userId) {
        User user = userRepository.findByIdOrElseThrows(userId);
        Board board = new Board(dto, user);
        Board savedBoard = boardRepository.save(board);
        return new BoardResponseDto(savedBoard);
    }


}

package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.MultipleChoice;
import com.project.azmoon.domain.TestQuestion;
import com.project.azmoon.repository.MultipleChoiceRepository;
import com.project.azmoon.service.MultipleChoiceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MultipleChoiceServiceImpl extends BaseEntityServiceImpl<MultipleChoice,Long, MultipleChoiceRepository> implements MultipleChoiceService {
    public MultipleChoiceServiceImpl(MultipleChoiceRepository repository) {
        super(repository);
    }

    @Override
    public List<MultipleChoice> findMultipleChoicesByTestQuestion(TestQuestion testQuestion) {
        return repository.findMultipleChoicesByTestQuestion(testQuestion);
    }
}

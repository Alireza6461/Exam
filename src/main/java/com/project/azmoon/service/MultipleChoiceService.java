package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.MultipleChoice;
import com.project.azmoon.domain.TestQuestion;

import java.util.List;

public interface MultipleChoiceService extends BaseEntityService<MultipleChoice,Long> {
    List<MultipleChoice> findMultipleChoicesByTestQuestion(TestQuestion testQuestion);
}

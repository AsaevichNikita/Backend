package org.tinkoff.mapper.mentor;

import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.Mentor;
import org.tinkoff.dto.mentor.MentorReadDto;
import org.tinkoff.mapper.Mapper;

@Component
public class MentorReadMapper implements Mapper<Mentor, MentorReadDto> {
    @Override
    public MentorReadDto map(Mentor object) {
        return new MentorReadDto(
                object.getExperience(),
                object.getHowCanHelp(),
                object.getSkills()
        );
    }
}

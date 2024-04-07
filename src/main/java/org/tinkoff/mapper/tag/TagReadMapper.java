package org.tinkoff.mapper.tag;

import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.Tag;
import org.tinkoff.dto.tag.TagReadDto;
import org.tinkoff.mapper.Mapper;

@Component
public class TagReadMapper implements Mapper<Tag, TagReadDto> {
    @Override
    public TagReadDto map(Tag tag) {
        return new TagReadDto(tag.getTag());
    }
}

package org.tinkoff.mapper.tag;

import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.Tag;
import org.tinkoff.dto.tag.TagCreateEditDto;
import org.tinkoff.mapper.Mapper;

@Component
public class TagCreateEditMapper implements Mapper<TagCreateEditDto, Tag> {

    @Override
    public Tag map(TagCreateEditDto tagCreateEditDto) {
        Tag tag = new Tag();
        tag.setTag(tagCreateEditDto.getTag());
        return tag;
    }

    @Override
    public Tag map(TagCreateEditDto tagCreateEditDto, Tag tag) {
        tag.setTag(tagCreateEditDto.getTag());
        return tag;
    }

}


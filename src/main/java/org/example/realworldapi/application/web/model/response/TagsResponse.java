package org.example.realworldapi.application.web.model.response;

import lombok.Getter;
import lombok.Setter;
import org.example.realworldapi.domain.model.tag.Tag;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TagsResponse {

    private List<String> tags;

    public TagsResponse(List<Tag> tags) {
        this.tags = tags.stream().map(Tag::getName).collect(Collectors.toList());
    }
}

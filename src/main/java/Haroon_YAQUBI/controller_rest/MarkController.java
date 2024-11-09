package Haroon_YAQUBI.controller_rest;

import Haroon_YAQUBI.Json_Views.JsonViews;
import Haroon_YAQUBI.dto.MarkDTO;
import Haroon_YAQUBI.entity.Mark;
import Haroon_YAQUBI.serivce.MarkService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mark")
@AllArgsConstructor
public class MarkController {

    private final MarkService markService;

    @PostMapping
    @JsonView(JsonViews.MarkShowView.class)
    @ResponseStatus(HttpStatus.CREATED)
    public Mark create(@RequestBody MarkDTO markDTO) {
        return markService.createMark(markDTO);
    }
}

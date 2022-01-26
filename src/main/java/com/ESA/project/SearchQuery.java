package com.ESA.project;
import lombok.AllArgsConstructor;

import com.ESA.project.AskQ.Type;
// import java.lang.reflect.Type;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchQuery {
    private String username;
    private Type type;
}

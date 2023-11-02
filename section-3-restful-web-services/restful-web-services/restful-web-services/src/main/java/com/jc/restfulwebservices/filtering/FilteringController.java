package com.jc.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("value1", "value2", "value3", "value4");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {  // All Field2s (2nd column) will not be returned to the client because of @JsonIgnore in SomeBean.java
        return Arrays.asList(new SomeBean("value1", "value2", "value3", "value4"),
                             new SomeBean("value5", "value6", "value7", "value8"));
    }
}

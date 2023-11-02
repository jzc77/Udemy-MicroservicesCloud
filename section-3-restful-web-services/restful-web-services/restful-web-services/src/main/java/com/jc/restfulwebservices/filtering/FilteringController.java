package com.jc.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    // Static filtering
    @GetMapping("/filtering")
    public SomeBean1 filtering() {
        return new SomeBean1("value1", "value2", "value3", "value4");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean1> filteringList() {  // All Field2s (2nd column) will not be returned to the client because of @JsonIgnore in SomeBean.java
        return Arrays.asList(new SomeBean1("value1", "value2", "value3", "value4"),
                             new SomeBean1("value5", "value6", "value7", "value8"));
    }


    // Dynamic filtering
    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue dynamicFiltering() {
        SomeBean2 someBean2 = new SomeBean2("value1", "value2", "value3", "value4");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean2);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue dynamicFilteringList() {  // Only want to return field2 and field3
        List<SomeBean2> list = Arrays.asList(new SomeBean2("value1", "value2", "value3", "value4"),
                                                   new SomeBean2("value5", "value6", "value7", "value8"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}

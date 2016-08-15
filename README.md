Project used to reproduce spring data rest issues with serializing entities that use jackson type info in inheritance scenarios.

See `com.example.ParentRestIntegrationTest.should_get_parents` to reproduce the issue.

Serialization fails with:
```
Failed to write HTTP message: org.springframework.http.converter.HttpMessageNotWritableException:
    Could not write content: Type id handling not implemented for type java.lang.Object (by serializer of type org.springframework.data.rest.webmvc.json.PersistentEntityJackson2Module$NestedEntitySerializer)
    (through reference chain: org.springframework.hateoas.PagedResources["_embedded"]->java.util.UnmodifiableMap["parents"]->java.util.ArrayList[0]->org.springframework.data.rest.webmvc.json.["content"]->com.example.Parent["valueHolder"]);
```

See https://jira.spring.io/browse/DATAREST-872
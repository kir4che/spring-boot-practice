package com.example.demo.objectmapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
// SON 字串 → User 時，有些 key 不存在就直接忽略繼續轉換其他 key。
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    Integer id;
    String name;

    @JsonProperty("contact_email")
    String‌ contactEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}

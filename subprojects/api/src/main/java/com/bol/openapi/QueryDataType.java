package com.bol.openapi;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class QueryDataType {

    private final Set<String> types = new LinkedHashSet<>();

    private QueryDataType(Set<String> types) {
        this.types.addAll(types);
    }

    @Override
    public String toString() {
        return StringUtils.join(types, ",");
    }

    public enum DataType {
        PRODUCTS("products"),
        CATEGORIES("categories"),
        REFINEMENTS("refinements");

        private final String queryValue;

        DataType(String queryValue) {
            this.queryValue = queryValue;
        }

        public String getQueryValue() {
            return queryValue;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Set<String> types;

        private Builder() {
            types = new LinkedHashSet<>();
        }

        public Builder add(DataType type) {
            types.add(type.getQueryValue());
            return this;
        }

        public QueryDataType create() {
            return new QueryDataType(types);
        }
    }
}

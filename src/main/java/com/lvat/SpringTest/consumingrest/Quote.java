package com.lvat.SpringTest.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Value {
        private int id;
        private String quote;

        public Value() {
        }

        public Value(int id, String quote) {
            this.id = id;
            this.quote = quote;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "id=" + id +
                    ", quote='" + quote + '\'' +
                    '}';
        }
    }

    private String type;
    private Value value;

    public Quote() {
    }

    public Quote(String type, Value value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}

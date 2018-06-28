package com.example.demo;

class TestBoidy {


    /**
     * data : {"type":"deleteAccount","attributes":{"reason":"sadasdasdsaas"}}
     */

    private DataBean data;

    public DataBean getData() { return data;}

    public void setData(DataBean data) { this.data = data;}

    @Override
    public String toString() {
        return "TestBoidy{" +
                "data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * type : deleteAccount
         * attributes : {"reason":"sadasdasdsaas"}
         */

        private String type;
        private AttributesBean attributes;

        public String getType() { return type;}

        public void setType(String type) { this.type = type;}

        public AttributesBean getAttributes() { return attributes;}

        public void setAttributes(AttributesBean attributes) { this.attributes = attributes;}

        @Override
        public String toString() {
            return "DataBean{" +
                    "type='" + type + '\'' +
                    ", attributes=" + attributes +
                    '}';
        }

        public static class AttributesBean {
            /**
             * reason : sadasdasdsaas
             */

            private String reason;

            public String getReason() { return reason;}

            public void setReason(String reason) { this.reason = reason;}

            @Override
            public String toString() {
                return "AttributesBean{" +
                        "reason='" + reason + '\'' +
                        '}';
            }
        }
    }
}

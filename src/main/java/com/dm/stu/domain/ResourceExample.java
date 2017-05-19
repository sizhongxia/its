package com.dm.stu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andResIdIsNull() {
            addCriterion("res_id is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("res_id is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(String value) {
            addCriterion("res_id =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(String value) {
            addCriterion("res_id <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(String value) {
            addCriterion("res_id >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(String value) {
            addCriterion("res_id >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(String value) {
            addCriterion("res_id <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(String value) {
            addCriterion("res_id <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLike(String value) {
            addCriterion("res_id like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotLike(String value) {
            addCriterion("res_id not like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<String> values) {
            addCriterion("res_id in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<String> values) {
            addCriterion("res_id not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(String value1, String value2) {
            addCriterion("res_id between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(String value1, String value2) {
            addCriterion("res_id not between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResFilenameIsNull() {
            addCriterion("res_filename is null");
            return (Criteria) this;
        }

        public Criteria andResFilenameIsNotNull() {
            addCriterion("res_filename is not null");
            return (Criteria) this;
        }

        public Criteria andResFilenameEqualTo(String value) {
            addCriterion("res_filename =", value, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameNotEqualTo(String value) {
            addCriterion("res_filename <>", value, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameGreaterThan(String value) {
            addCriterion("res_filename >", value, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("res_filename >=", value, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameLessThan(String value) {
            addCriterion("res_filename <", value, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameLessThanOrEqualTo(String value) {
            addCriterion("res_filename <=", value, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameLike(String value) {
            addCriterion("res_filename like", value, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameNotLike(String value) {
            addCriterion("res_filename not like", value, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameIn(List<String> values) {
            addCriterion("res_filename in", values, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameNotIn(List<String> values) {
            addCriterion("res_filename not in", values, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameBetween(String value1, String value2) {
            addCriterion("res_filename between", value1, value2, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResFilenameNotBetween(String value1, String value2) {
            addCriterion("res_filename not between", value1, value2, "resFilename");
            return (Criteria) this;
        }

        public Criteria andResSizeIsNull() {
            addCriterion("res_size is null");
            return (Criteria) this;
        }

        public Criteria andResSizeIsNotNull() {
            addCriterion("res_size is not null");
            return (Criteria) this;
        }

        public Criteria andResSizeEqualTo(Long value) {
            addCriterion("res_size =", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeNotEqualTo(Long value) {
            addCriterion("res_size <>", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeGreaterThan(Long value) {
            addCriterion("res_size >", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("res_size >=", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeLessThan(Long value) {
            addCriterion("res_size <", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeLessThanOrEqualTo(Long value) {
            addCriterion("res_size <=", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeIn(List<Long> values) {
            addCriterion("res_size in", values, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeNotIn(List<Long> values) {
            addCriterion("res_size not in", values, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeBetween(Long value1, Long value2) {
            addCriterion("res_size between", value1, value2, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeNotBetween(Long value1, Long value2) {
            addCriterion("res_size not between", value1, value2, "resSize");
            return (Criteria) this;
        }

        public Criteria andResPathIsNull() {
            addCriterion("res_path is null");
            return (Criteria) this;
        }

        public Criteria andResPathIsNotNull() {
            addCriterion("res_path is not null");
            return (Criteria) this;
        }

        public Criteria andResPathEqualTo(String value) {
            addCriterion("res_path =", value, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathNotEqualTo(String value) {
            addCriterion("res_path <>", value, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathGreaterThan(String value) {
            addCriterion("res_path >", value, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathGreaterThanOrEqualTo(String value) {
            addCriterion("res_path >=", value, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathLessThan(String value) {
            addCriterion("res_path <", value, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathLessThanOrEqualTo(String value) {
            addCriterion("res_path <=", value, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathLike(String value) {
            addCriterion("res_path like", value, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathNotLike(String value) {
            addCriterion("res_path not like", value, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathIn(List<String> values) {
            addCriterion("res_path in", values, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathNotIn(List<String> values) {
            addCriterion("res_path not in", values, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathBetween(String value1, String value2) {
            addCriterion("res_path between", value1, value2, "resPath");
            return (Criteria) this;
        }

        public Criteria andResPathNotBetween(String value1, String value2) {
            addCriterion("res_path not between", value1, value2, "resPath");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeIsNull() {
            addCriterion("res_upload_time is null");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeIsNotNull() {
            addCriterion("res_upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeEqualTo(Date value) {
            addCriterion("res_upload_time =", value, "resUploadTime");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeNotEqualTo(Date value) {
            addCriterion("res_upload_time <>", value, "resUploadTime");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeGreaterThan(Date value) {
            addCriterion("res_upload_time >", value, "resUploadTime");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("res_upload_time >=", value, "resUploadTime");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeLessThan(Date value) {
            addCriterion("res_upload_time <", value, "resUploadTime");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("res_upload_time <=", value, "resUploadTime");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeIn(List<Date> values) {
            addCriterion("res_upload_time in", values, "resUploadTime");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeNotIn(List<Date> values) {
            addCriterion("res_upload_time not in", values, "resUploadTime");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeBetween(Date value1, Date value2) {
            addCriterion("res_upload_time between", value1, value2, "resUploadTime");
            return (Criteria) this;
        }

        public Criteria andResUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("res_upload_time not between", value1, value2, "resUploadTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
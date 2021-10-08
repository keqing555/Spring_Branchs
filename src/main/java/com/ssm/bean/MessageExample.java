package com.ssm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlIsNull() {
            addCriterion("attachmentUrl is null");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlIsNotNull() {
            addCriterion("attachmentUrl is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlEqualTo(String value) {
            addCriterion("attachmentUrl =", value, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlNotEqualTo(String value) {
            addCriterion("attachmentUrl <>", value, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlGreaterThan(String value) {
            addCriterion("attachmentUrl >", value, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlGreaterThanOrEqualTo(String value) {
            addCriterion("attachmentUrl >=", value, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlLessThan(String value) {
            addCriterion("attachmentUrl <", value, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlLessThanOrEqualTo(String value) {
            addCriterion("attachmentUrl <=", value, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlLike(String value) {
            addCriterion("attachmentUrl like", value, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlNotLike(String value) {
            addCriterion("attachmentUrl not like", value, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlIn(List<String> values) {
            addCriterion("attachmentUrl in", values, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlNotIn(List<String> values) {
            addCriterion("attachmentUrl not in", values, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlBetween(String value1, String value2) {
            addCriterion("attachmentUrl between", value1, value2, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andAttachmenturlNotBetween(String value1, String value2) {
            addCriterion("attachmentUrl not between", value1, value2, "attachmenturl");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendtime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendtime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendtime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendtime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendtime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendtime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendtime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendtime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendtime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendtime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendtime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendstateIsNull() {
            addCriterion("sendstate is null");
            return (Criteria) this;
        }

        public Criteria andSendstateIsNotNull() {
            addCriterion("sendstate is not null");
            return (Criteria) this;
        }

        public Criteria andSendstateEqualTo(String value) {
            addCriterion("sendstate =", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateNotEqualTo(String value) {
            addCriterion("sendstate <>", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateGreaterThan(String value) {
            addCriterion("sendstate >", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateGreaterThanOrEqualTo(String value) {
            addCriterion("sendstate >=", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateLessThan(String value) {
            addCriterion("sendstate <", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateLessThanOrEqualTo(String value) {
            addCriterion("sendstate <=", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateLike(String value) {
            addCriterion("sendstate like", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateNotLike(String value) {
            addCriterion("sendstate not like", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateIn(List<String> values) {
            addCriterion("sendstate in", values, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateNotIn(List<String> values) {
            addCriterion("sendstate not in", values, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateBetween(String value1, String value2) {
            addCriterion("sendstate between", value1, value2, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateNotBetween(String value1, String value2) {
            addCriterion("sendstate not between", value1, value2, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendeidIsNull() {
            addCriterion("sendEid is null");
            return (Criteria) this;
        }

        public Criteria andSendeidIsNotNull() {
            addCriterion("sendEid is not null");
            return (Criteria) this;
        }

        public Criteria andSendeidEqualTo(Long value) {
            addCriterion("sendEid =", value, "sendeid");
            return (Criteria) this;
        }

        public Criteria andSendeidNotEqualTo(Long value) {
            addCriterion("sendEid <>", value, "sendeid");
            return (Criteria) this;
        }

        public Criteria andSendeidGreaterThan(Long value) {
            addCriterion("sendEid >", value, "sendeid");
            return (Criteria) this;
        }

        public Criteria andSendeidGreaterThanOrEqualTo(Long value) {
            addCriterion("sendEid >=", value, "sendeid");
            return (Criteria) this;
        }

        public Criteria andSendeidLessThan(Long value) {
            addCriterion("sendEid <", value, "sendeid");
            return (Criteria) this;
        }

        public Criteria andSendeidLessThanOrEqualTo(Long value) {
            addCriterion("sendEid <=", value, "sendeid");
            return (Criteria) this;
        }

        public Criteria andSendeidIn(List<Long> values) {
            addCriterion("sendEid in", values, "sendeid");
            return (Criteria) this;
        }

        public Criteria andSendeidNotIn(List<Long> values) {
            addCriterion("sendEid not in", values, "sendeid");
            return (Criteria) this;
        }

        public Criteria andSendeidBetween(Long value1, Long value2) {
            addCriterion("sendEid between", value1, value2, "sendeid");
            return (Criteria) this;
        }

        public Criteria andSendeidNotBetween(Long value1, Long value2) {
            addCriterion("sendEid not between", value1, value2, "sendeid");
            return (Criteria) this;
        }

        public Criteria andReceipteidIsNull() {
            addCriterion("receiptEid is null");
            return (Criteria) this;
        }

        public Criteria andReceipteidIsNotNull() {
            addCriterion("receiptEid is not null");
            return (Criteria) this;
        }

        public Criteria andReceipteidEqualTo(Long value) {
            addCriterion("receiptEid =", value, "receipteid");
            return (Criteria) this;
        }

        public Criteria andReceipteidNotEqualTo(Long value) {
            addCriterion("receiptEid <>", value, "receipteid");
            return (Criteria) this;
        }

        public Criteria andReceipteidGreaterThan(Long value) {
            addCriterion("receiptEid >", value, "receipteid");
            return (Criteria) this;
        }

        public Criteria andReceipteidGreaterThanOrEqualTo(Long value) {
            addCriterion("receiptEid >=", value, "receipteid");
            return (Criteria) this;
        }

        public Criteria andReceipteidLessThan(Long value) {
            addCriterion("receiptEid <", value, "receipteid");
            return (Criteria) this;
        }

        public Criteria andReceipteidLessThanOrEqualTo(Long value) {
            addCriterion("receiptEid <=", value, "receipteid");
            return (Criteria) this;
        }

        public Criteria andReceipteidIn(List<Long> values) {
            addCriterion("receiptEid in", values, "receipteid");
            return (Criteria) this;
        }

        public Criteria andReceipteidNotIn(List<Long> values) {
            addCriterion("receiptEid not in", values, "receipteid");
            return (Criteria) this;
        }

        public Criteria andReceipteidBetween(Long value1, Long value2) {
            addCriterion("receiptEid between", value1, value2, "receipteid");
            return (Criteria) this;
        }

        public Criteria andReceipteidNotBetween(Long value1, Long value2) {
            addCriterion("receiptEid not between", value1, value2, "receipteid");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNull() {
            addCriterion("messagetype is null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNotNull() {
            addCriterion("messagetype is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeEqualTo(String value) {
            addCriterion("messagetype =", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotEqualTo(String value) {
            addCriterion("messagetype <>", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThan(String value) {
            addCriterion("messagetype >", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThanOrEqualTo(String value) {
            addCriterion("messagetype >=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThan(String value) {
            addCriterion("messagetype <", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThanOrEqualTo(String value) {
            addCriterion("messagetype <=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLike(String value) {
            addCriterion("messagetype like", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotLike(String value) {
            addCriterion("messagetype not like", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIn(List<String> values) {
            addCriterion("messagetype in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotIn(List<String> values) {
            addCriterion("messagetype not in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeBetween(String value1, String value2) {
            addCriterion("messagetype between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotBetween(String value1, String value2) {
            addCriterion("messagetype not between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("remark2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("remark2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNull() {
            addCriterion("remark3 is null");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNotNull() {
            addCriterion("remark3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("remark3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            addCriterion("remark3 <>", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            addCriterion("remark3 >", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            addCriterion("remark3 >=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThan(String value) {
            addCriterion("remark3 <", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            addCriterion("remark3 <=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Like(String value) {
            addCriterion("remark3 like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotLike(String value) {
            addCriterion("remark3 not like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3In(List<String> values) {
            addCriterion("remark3 in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            addCriterion("remark3 not in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            addCriterion("remark3 not between", value1, value2, "remark3");
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
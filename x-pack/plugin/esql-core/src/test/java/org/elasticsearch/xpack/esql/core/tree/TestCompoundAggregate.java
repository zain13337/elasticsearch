/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.xpack.esql.core.tree;

import org.elasticsearch.xpack.esql.core.expression.Expression;
import org.elasticsearch.xpack.esql.core.expression.function.aggregate.AggregateFunction;
import org.elasticsearch.xpack.esql.core.expression.function.aggregate.CompoundAggregate;
import org.elasticsearch.xpack.esql.core.type.DataType;
import org.elasticsearch.xpack.esql.core.type.DataTypes;

import java.util.List;

public class TestCompoundAggregate extends AggregateFunction implements CompoundAggregate {

    public TestCompoundAggregate(Source source, Expression field) {
        super(source, field);
    }

    @Override
    protected NodeInfo<TestCompoundAggregate> info() {
        return NodeInfo.create(this, TestCompoundAggregate::new, field());
    }

    @Override
    public TestCompoundAggregate replaceChildren(List<Expression> newChildren) {
        return new TestCompoundAggregate(source(), newChildren.get(0));
    }

    @Override
    public DataType dataType() {
        return DataTypes.DOUBLE;
    }
}

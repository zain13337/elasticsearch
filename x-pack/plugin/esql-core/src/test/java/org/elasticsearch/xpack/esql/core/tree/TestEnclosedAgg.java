/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.xpack.esql.core.tree;

import org.elasticsearch.xpack.esql.core.expression.Expression;
import org.elasticsearch.xpack.esql.core.expression.function.aggregate.AggregateFunction;
import org.elasticsearch.xpack.esql.core.expression.function.aggregate.EnclosedAgg;
import org.elasticsearch.xpack.esql.core.type.DataType;
import org.elasticsearch.xpack.esql.core.type.DataTypes;

import java.util.List;

public class TestEnclosedAgg extends AggregateFunction implements EnclosedAgg {

    public TestEnclosedAgg(Source source, Expression field) {
        super(source, field);
    }

    @Override
    protected NodeInfo<TestEnclosedAgg> info() {
        return NodeInfo.create(this, TestEnclosedAgg::new, field());
    }

    @Override
    public TestEnclosedAgg replaceChildren(List<Expression> newChildren) {
        return new TestEnclosedAgg(source(), newChildren.get(0));
    }

    @Override
    public String innerName() {
        return "testEnclosed";
    }

    @Override
    public DataType dataType() {
        return DataTypes.DOUBLE;
    }
}

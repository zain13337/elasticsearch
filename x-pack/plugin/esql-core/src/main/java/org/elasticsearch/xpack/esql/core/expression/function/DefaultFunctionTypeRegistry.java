/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */
package org.elasticsearch.xpack.esql.core.expression.function;

import org.elasticsearch.xpack.esql.core.expression.function.aggregate.AggregateFunction;
import org.elasticsearch.xpack.esql.core.expression.function.scalar.ScalarFunction;

public class DefaultFunctionTypeRegistry implements FunctionTypeRegistry {

    public static final DefaultFunctionTypeRegistry INSTANCE = new DefaultFunctionTypeRegistry();

    private enum Types {
        AGGREGATE(AggregateFunction.class),
        SCALAR(ScalarFunction.class);

        private Class<? extends Function> baseClass;

        Types(Class<? extends Function> base) {
            this.baseClass = base;
        }
    }

    @Override
    public String type(Class<? extends Function> clazz) {
        for (Types type : Types.values()) {
            if (type.baseClass.isAssignableFrom(clazz)) {
                return type.name();
            }
        }
        return "UNKNOWN";
    }
}

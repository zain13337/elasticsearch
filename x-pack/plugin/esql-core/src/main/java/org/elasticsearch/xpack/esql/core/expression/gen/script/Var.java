/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */
package org.elasticsearch.xpack.esql.core.expression.gen.script;

class Var extends Param<Object> {

    Var(Object value) {
        super(value);
    }

    @Override
    public String prefix() {
        return "v";
    }
}

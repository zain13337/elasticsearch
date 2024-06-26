/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */
package org.elasticsearch.xpack.esql.core.expression.gen.script;

import org.elasticsearch.xpack.esql.core.expression.function.grouping.GroupingFunction;

class Grouping extends Param<GroupingFunction> {

    Grouping(GroupingFunction groupRef) {
        super(groupRef);
    }

    String groupName() {
        return Integer.toHexString(value().hashCode());
    }

    @Override
    public String prefix() {
        return "g";
    }
}

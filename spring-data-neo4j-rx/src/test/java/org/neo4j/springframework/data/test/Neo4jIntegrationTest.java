/*
 * Copyright (c) 2019 "Neo4j,"
 * Neo4j Sweden AB [https://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.springframework.data.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.DirtiesContext;

/**
 * This annotations triggers the {@link Neo4jExtension}, that provides a driver instance for Neo4j integration tests.
 * The important point here is that the extension possibly dirties a Spring context by closing the driver instance, so
 * it has been meta annotated with {@link DirtiesContext}.
 *
 * That issue happens mostly when one and the same integration tests is run several times via an IDE: Spring will detect
 * that the context configuration is the same and reuse the old context based on contextual information from the first run.
 * The Neo4j extension will dutiful create a new connection and driver instance, but Spring won't never use it.
 *
 * @author Michael J. Simons
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(Neo4jExtension.class)
@DirtiesContext
public @interface Neo4jIntegrationTest {
}
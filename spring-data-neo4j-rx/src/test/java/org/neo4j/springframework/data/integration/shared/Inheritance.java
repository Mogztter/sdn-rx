/*
 * Copyright (c) 2019-2020 "Neo4j,"
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
package org.neo4j.springframework.data.integration.shared;

import java.util.Objects;

import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;

/**
 * @author Gerrit Meier
 */
public class Inheritance {

	/**
	 * base class
	 */
	@Node
	public static abstract class BaseClass {

		@Id @GeneratedValue private Long id;

	}

	/**
	 * first concrete implementation
	 */
	@Node
	public static class ConcreteClassA extends BaseClass {

		private final String name;

		public ConcreteClassA(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			ConcreteClassA that = (ConcreteClassA) o;
			return name.equals(that.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}
	}

	/**
	 * second concrete implementation
	 */
	@Node
	public static class ConcreteClassB extends BaseClass {

		private final Integer age;

		public ConcreteClassB(Integer age) {
			this.age = age;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			ConcreteClassB that = (ConcreteClassB) o;
			return age.equals(that.age);
		}

		@Override
		public int hashCode() {
			return Objects.hash(age);
		}
	}
}

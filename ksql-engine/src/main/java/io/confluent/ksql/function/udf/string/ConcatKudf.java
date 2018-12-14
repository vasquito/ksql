/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License; you may not use this file
 * except in compliance with the License.  You may obtain a copy of the License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.function.udf.string;

import io.confluent.ksql.function.KsqlFunctionException;
import io.confluent.ksql.function.udf.Kudf;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConcatKudf implements Kudf {
  public static final String NAME = "CONCAT";

  @Override
  public String evaluate(final Object... args) {
    if (args.length < 2) {
      throw new KsqlFunctionException(NAME + " should have at least two input argument.");
    }

    return Arrays.stream(args)
        .filter(Objects::nonNull)
        .map(Object::toString)
        .collect(Collectors.joining());
  }
}

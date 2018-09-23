/*
 * Copyright 2018 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cd.go.contrib.plugins.configrepo.groovy.dsl;

import com.fasterxml.jackson.annotation.JsonProperty;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.SimpleType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

import static groovy.lang.Closure.DELEGATE_ONLY;

/**
 * Represents a
 * <a href="https://docs.gocd.org/current/configuration/configuration_reference.html#p4">p4 material config</a>.
 * <p>
 * {@includeCode p4.material.groovy }
 *
 * @see <a href="https://docs.gocd.org/current/configuration/configuration_reference.html#p4">p4 material config</a>.
 * for detailed description of p4 config.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class P4Material extends ScmMaterial<P4Material> {

    @JsonProperty("port")
    private String port;

    @JsonProperty("username")
    private String username;

    /**
     * The encrypted password
     *
     * @see <a href='https://api.gocd.org/current/#encrypt-a-plain-text-value'>Encryption API</a>
     */
    @JsonProperty("encrypted_password")
    private String encryptedPassword;

    @JsonProperty("use_tickets")
    private Boolean useTickets;

    @JsonProperty("view")
    @NotEmpty
    private String view;

    P4Material() {
        this(null);
    }

    P4Material(@DelegatesTo(value = P4Material.class, strategy = DELEGATE_ONLY) @ClosureParams(value = SimpleType.class, options = "cd.go.contrib.plugins.configrepo.groovy.dsl.P4Material") Closure cl) {
        this(null, cl);
    }

    P4Material(String name, @DelegatesTo(value = P4Material.class, strategy = DELEGATE_ONLY) @ClosureParams(value = SimpleType.class, options = "cd.go.contrib.plugins.configrepo.groovy.dsl.P4Material") Closure cl) {
        super(name);
        configure(cl);
    }

}

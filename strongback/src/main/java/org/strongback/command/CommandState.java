/*
 * Strongback
 * Copyright 2015, Strongback and individual contributors by the @authors tag.
 * See the COPYRIGHT.txt in the distribution for a full listing of individual
 * contributors.
 *
 * Licensed under the MIT License; you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.strongback.command;

/**
 * Defines the current state of a {@link Command}. The state transition is as follows:
 *
 * <pre>
 *   UNINITIALIZED ----> RUNNING ----> FINISHED ----> FINALIZED
 *
 *  <li>{@link #UNINITIALIZED} - The {@link Command} has not been initialized
 * or executed yet. <li>{@link #INITIALIZED} - The {@link Command} has been initialized but has not been executed yet. <li>
 * {@link #RUNNING} - The {@link Command} has been initialized and executed at least once. <li>{@link #INTERUPTED} - The
 * {@link Command} has been interrupted, but it has not been processed. <li>{@link #FINISHED} - The {@link Command} has
 * finished but has not been finalized.
 * <li>{@link #FINALIZED} - The {@link Command} has finished and been cleaned up.
 */
public enum CommandState {
    /**
     * The {@link Command} is ready to be {@link Command#initialize() initialized}.
     */
    UNINITIALIZED,
    /**
     * The {@link Command} has been {@link Command#initialize() initialized} and is ready to {@link Command#execute()
     * executed}.
     */
    RUNNING,
    /**
     * The {@link Command} has completed {@link #RUNNING running} (because {@link Command#execute()} returned {@code true}).
     */
    FINISHED,
    /**
     * The {@link Command} has completed running and is ready to be {@link Command#end() finished}.
     */
    FINALIZED,
    /**
     * The {@link Command} has been interrupted before completion, but the interrupt has not been processed.
     */
    INTERUPTED,
}
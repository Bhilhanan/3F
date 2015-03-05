/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-01-14 17:53:03 UTC)
 * on 2015-03-05 at 10:20:24 UTC 
 * Modify at your own risk.
 */

package com.threef.datastore.Entities.annotationendpoint.model;

/**
 * Model definition for ActionsRepository.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the annotationendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class ActionsRepository extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Action action;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<Annotation> annotationList;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String methodName;

  /**
   * @return value or {@code null} for none
   */
  public Action getAction() {
    return action;
  }

  /**
   * @param action action or {@code null} for none
   */
  public ActionsRepository setAction(Action action) {
    this.action = action;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<Annotation> getAnnotationList() {
    return annotationList;
  }

  /**
   * @param annotationList annotationList or {@code null} for none
   */
  public ActionsRepository setAnnotationList(java.util.List<Annotation> annotationList) {
    this.annotationList = annotationList;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public ActionsRepository setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMethodName() {
    return methodName;
  }

  /**
   * @param methodName methodName or {@code null} for none
   */
  public ActionsRepository setMethodName(java.lang.String methodName) {
    this.methodName = methodName;
    return this;
  }

  @Override
  public ActionsRepository set(String fieldName, Object value) {
    return (ActionsRepository) super.set(fieldName, value);
  }

  @Override
  public ActionsRepository clone() {
    return (ActionsRepository) super.clone();
  }

}

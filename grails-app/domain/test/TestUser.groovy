/* Copyright 2006-2012 SpringSource.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class TestUser {

	static transients = ['roles', 'roleNames']

	String loginName
	String passwrrd
	boolean enabld
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Set<TestRole> getRoles() { TestUserRole.findAllByUser(this).collect { it.role } }

	Collection<String> getRoleNames() { roles*.auth }

	static constraints = {
		loginName blank: false, unique: true
		passwrrd blank: false
	}
}

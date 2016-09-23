/*
 * Copyright 2005-2016 the original author or authors.
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

package es.organization.ldap.engine.model.repository.test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.naming.ldap.LdapName;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.organization.ldap.engine.model.TreeLdap;
import es.organization.ldap.engine.model.repository.TreeLdapRepository;
import es.organization.ldap.engine.model.view.TreeLdapView;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = { "/config/testContext.xml" })
public class TreeLdapRepositoryTest extends AbstractJUnit4SpringContextTests
{

	@Autowired
	private TreeLdapRepository treeLdapRepository;


	@Test
	public void testGetLdapTree()
	{
		TreeLdap treeLdap = treeLdapRepository.getLdapTree(LdapUtils.newLdapName("c=Sweden"));
		treeLdap.renderizeView(new TestVisitor());
	}

	private static final class TestVisitor implements TreeLdapView
	{
		private static final LdapName	DN_1	= LdapUtils.newLdapName("c=Sweden");
		private static final LdapName	DN_2	= LdapUtils.newLdapName("ou=company1,c=Sweden");
		private static final LdapName	DN_3	= LdapUtils.newLdapName("cn=Some Person,ou=company1,c=Sweden");
		private static final LdapName	DN_4	= LdapUtils.newLdapName("cn=Some Person2,ou=company1,c=Sweden");

		private Map<LdapName, Integer>	names	= new LinkedHashMap<LdapName, Integer>();

		private Iterator<LdapName>		keyIterator;


		public TestVisitor()
		{
			names.put(DN_1, 0);
			names.put(DN_2, 1);
			names.put(DN_3, 2);
			names.put(DN_4, 2);

			keyIterator = names.keySet().iterator();
		}


		public void inspect(DirContextOperations node, int currentDepth)
		{
			LdapName next = keyIterator.next();
			assertThat(node.getDn()).isEqualTo(next);
			assertThat(currentDepth).isEqualTo(names.get(next).intValue());
		}
	}

}

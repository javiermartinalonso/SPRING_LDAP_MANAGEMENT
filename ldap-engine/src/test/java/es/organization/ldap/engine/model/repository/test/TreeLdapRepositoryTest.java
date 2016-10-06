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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.naming.ldap.LdapName;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import es.organization.ldap.engine.model.TreeLdap;
import es.organization.ldap.engine.model.repository.TreeLdapRepository;
import es.organization.ldap.engine.model.view.TreeLdapView;

@ContextConfiguration(locations =
	{
			"/spring-config-test/testContext.xml"
	})
public class TreeLdapRepositoryTest extends AbstractJUnit4SpringContextTests
{

	@Autowired
	private TreeLdapRepository treeLdapRepository;


	@Test
	public void testGetLdapTree()
	{
		TreeLdap treeLdap = treeLdapRepository.getLdapTree(LdapUtils.newLdapName("ou=acme"));
		treeLdap.renderizeView(new TestVisitor());
	}

	private static final class TestVisitor implements TreeLdapView
	{
		private static final LdapName	DN_1	= LdapUtils.newLdapName("ou=acme");

			private static final LdapName	DN_2_1	= LdapUtils.newLdapName("ou=people,ou=acme");
				private static final LdapName	DN_2_1_1	= LdapUtils.newLdapName("cn=Jane Doe,ou=people,ou=acme");
				private static final LdapName	DN_2_1_2	= LdapUtils.newLdapName("cn=John Doe,ou=people,ou=acme");
				private static final LdapName	DN_2_1_3	= LdapUtils.newLdapName("cn=John Smith,ou=people,ou=acme");
				private static final LdapName	DN_2_1_4	= LdapUtils.newLdapName("cn=Mordac Preventor of IS,ou=people,ou=acme");
				private static final LdapName	DN_2_1_5	= LdapUtils.newLdapName("cn=Some Dude,ou=people,ou=acme");
				private static final LdapName	DN_2_1_6	= LdapUtils.newLdapName("cn=System,ou=people,ou=acme");
	
			private static final LdapName	DN_2_2	= LdapUtils.newLdapName("ou=applications,ou=acme");
			
				private static final LdapName	DN_2_2_1	= LdapUtils.newLdapName("ou=application1,ou=applications,ou=acme");
					private static final LdapName	DN_2_2_1_1	= LdapUtils.newLdapName("ou=groups,ou=application1,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_1_1_1	= LdapUtils.newLdapName("cn=ROLE_USER,ou=groups,ou=application1,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_1_1_2	= LdapUtils.newLdapName("cn=POWER_USER,ou=groups,ou=application1,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_1_1_3	= LdapUtils.newLdapName("cn=ROLE_ADMIN,ou=groups,ou=application1,ou=applications,ou=acme");						
					private static final LdapName	DN_2_2_1_2	= LdapUtils.newLdapName("ou=people,ou=application1,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_1_2_1	= LdapUtils.newLdapName("cn=John Doe,ou=people,ou=application1,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_1_2_2	= LdapUtils.newLdapName("cn=Some Dude,ou=people,ou=application1,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_1_2_3	= LdapUtils.newLdapName("cn=John Smith,ou=people,ou=application1,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_1_2_4	= LdapUtils.newLdapName("cn=Mordac Preventor of IS,ou=people,ou=application1,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_1_2_5	= LdapUtils.newLdapName("cn=System,ou=people,ou=application1,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_1_2_6	= LdapUtils.newLdapName("cn=Jane Doe,ou=people,ou=application1,ou=applications,ou=acme");
	
				private static final LdapName	DN_2_2_2	= LdapUtils.newLdapName("ou=application2,ou=applications,ou=acme");
					private static final LdapName	DN_2_2_2_1	= LdapUtils.newLdapName("ou=groups,ou=application2,ou=applications,ou=acme");	
						private static final LdapName	DN_2_2_2_1_1	= LdapUtils.newLdapName("cn=ROLE_USER,ou=groups,ou=application2,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_2_1_2	= LdapUtils.newLdapName("cn=POWER_USER,ou=groups,ou=application2,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_2_1_3	= LdapUtils.newLdapName("cn=ROLE_ADMIN,ou=groups,ou=application2,ou=applications,ou=acme");							
					private static final LdapName	DN_2_2_2_2	= LdapUtils.newLdapName("ou=people,ou=application2,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_2_2_1	= LdapUtils.newLdapName("cn=John Doe,ou=people,ou=application2,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_2_2_2	= LdapUtils.newLdapName("cn=Some Dude,ou=people,ou=application2,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_2_2_3	= LdapUtils.newLdapName("cn=John Smith,ou=people,ou=application2,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_2_2_4	= LdapUtils.newLdapName("cn=Mordac Preventor of IS,ou=people,ou=application2,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_2_2_5	= LdapUtils.newLdapName("cn=System,ou=people,ou=application2,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_2_2_6	= LdapUtils.newLdapName("cn=Jane Doe,ou=people,ou=application2,ou=applications,ou=acme");
		
				private static final LdapName	DN_2_2_3	= LdapUtils.newLdapName("ou=application3,ou=applications,ou=acme");
					private static final LdapName	DN_2_2_3_1	= LdapUtils.newLdapName("ou=groups,ou=application3,ou=applications,ou=acme");	
						private static final LdapName	DN_2_2_3_1_1	= LdapUtils.newLdapName("cn=ROLE_USER,ou=groups,ou=application3,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_3_1_2	= LdapUtils.newLdapName("cn=POWER_USER,ou=groups,ou=application3,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_3_1_3	= LdapUtils.newLdapName("cn=ROLE_ADMIN,ou=groups,ou=application3,ou=applications,ou=acme");							
					private static final LdapName	DN_2_2_3_2	= LdapUtils.newLdapName("ou=people,ou=application3,ou=applications,ou=acme");				
						private static final LdapName	DN_2_2_3_2_1	= LdapUtils.newLdapName("cn=John Doe,ou=people,ou=application3,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_3_2_2	= LdapUtils.newLdapName("cn=Some Dude,ou=people,ou=application3,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_3_2_3	= LdapUtils.newLdapName("cn=John Smith,ou=people,ou=application3,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_3_2_4	= LdapUtils.newLdapName("cn=Mordac Preventor of IS,ou=people,ou=application3,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_3_2_5	= LdapUtils.newLdapName("cn=System,ou=people,ou=application3,ou=applications,ou=acme");
						private static final LdapName	DN_2_2_3_2_6	= LdapUtils.newLdapName("cn=Jane Doe,ou=people,ou=application3,ou=applications,ou=acme");

		private Map<LdapName, Integer>	names	= new LinkedHashMap<LdapName, Integer>();

		private Iterator<LdapName>		keyIterator;


		public TestVisitor()
		{
			names.put(DN_1, 0);
			names.put(DN_2_1, 1);
				names.put(DN_2_1_1, 2);
				names.put(DN_2_1_2, 2);
				names.put(DN_2_1_3, 2);
				names.put(DN_2_1_4, 2);
				names.put(DN_2_1_5, 2);
				names.put(DN_2_1_6, 2);
			names.put(DN_2_2, 1);
				names.put(DN_2_2_1, 2);
					names.put(DN_2_2_1_1, 3);	
						names.put(DN_2_2_1_1_1, 4);
						names.put(DN_2_2_1_1_2, 4);
						names.put(DN_2_2_1_1_3, 4);					
					names.put(DN_2_2_1_2, 3);
						names.put(DN_2_2_1_2_1, 4);
						names.put(DN_2_2_1_2_2, 4);
						names.put(DN_2_2_1_2_3, 4);
						names.put(DN_2_2_1_2_4, 4);
						names.put(DN_2_2_1_2_5, 4);
						names.put(DN_2_2_1_2_6, 4);						
				names.put(DN_2_2_2, 2);					
					names.put(DN_2_2_2_1, 3);
						names.put(DN_2_2_2_1_1, 4);
						names.put(DN_2_2_2_1_2, 4);
						names.put(DN_2_2_2_1_3, 4);						
					names.put(DN_2_2_2_2, 3);
						names.put(DN_2_2_2_2_1, 4);
						names.put(DN_2_2_2_2_2, 4);
						names.put(DN_2_2_2_2_3, 4);
						names.put(DN_2_2_2_2_4, 4);
						names.put(DN_2_2_2_2_5, 4);
						names.put(DN_2_2_2_2_6, 4);		
				names.put(DN_2_2_3, 2);					
					names.put(DN_2_2_3_1, 3);				
						names.put(DN_2_2_3_1_1, 4);
						names.put(DN_2_2_3_1_2, 4);
						names.put(DN_2_2_3_1_3, 4);						
					names.put(DN_2_2_3_2, 3);
						names.put(DN_2_2_3_2_1, 4);
						names.put(DN_2_2_3_2_2, 4);
						names.put(DN_2_2_3_2_3, 4);
						names.put(DN_2_2_3_2_4, 4);
						names.put(DN_2_2_3_2_5, 4);
						names.put(DN_2_2_3_2_6, 4);					

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

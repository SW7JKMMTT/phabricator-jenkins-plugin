package com.uber.jenkins.phabricator.provider;

import com.uber.jenkins.phabricator.PhabricatorNotifier;
import com.uber.jenkins.phabricator.coverage.CoverageProvider;
import com.uber.jenkins.phabricator.utils.TestUtils;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BaseProviderTest {
    @Rule
    public JenkinsRule j = new JenkinsRule();

    @Test
    public void testGetInvalidProvider() {
        Provider<CoverageProvider> provider = getProvider();
        assertNull(provider.getInstance("nonexistent.classname"));
    }

    @Test
    public void testGetValidProvider() {
        Provider<CoverageProvider> provider = getProvider();
        //TODO: Since we no longer have a  provider
        assertNull(provider.getInstance(PhabricatorNotifier.COBERTURA_CLASS_NAME));
    }

    private Provider<CoverageProvider> getProvider() {
        return new BaseProvider<CoverageProvider>(
                j.getInstance(),
                "cobertura",
                TestUtils.getDefaultLogger()
        );
    }
}

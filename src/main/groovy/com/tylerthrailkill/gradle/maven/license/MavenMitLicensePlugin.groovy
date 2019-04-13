package com.tylerthrailkill.gradle.maven.license

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication

class MavenMitLicensePlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.plugins.apply "nebula.maven-publish" 
        project.publishing {
            publications {
                nebula(MavenPublication)
                withType(MavenPublication) { publication ->
                    configureLicense(publication)
                }
            }
        }
    }

    def configureLicense(MavenPublication publication) {
        publication.pom.licenses {
            license {
                name = 'The MIT License'
                url = 'https://opensource.org/licenses/MIT'
                distribution = 'repo'
            }
        }
    }
}

SKELETON APP USING CAST WICKET MODULES

This application demonstrates basic setup needed to use some of the basic infrastructure that the CAST
Wicket Modules provide:
  Base database structure
  Event logging

BUILD AND DEPLOYMENT INSTRUCTIONS

* GIT BRANCHES

Suggested branch naming:
  "master" to track what's deployed on the live site
  "develop" to track current mainline development, periodically deployed to a QA site
  "mockup" for development of front-end code, gets pulled into develop or a feature branch when ready.
  "content" for any content automatically updated from a WebDAV content folder that people edit with XML Mind.
    There is a cron job (running as apache on webserver5) that can push updates.
    The content from the WebDAV server can also be used directly by a QA site.
    When you want to push the updated to content to the live site, merge this branch in to "master" (normally via "develop")
  "feature/JIRA-ID-description" for development of a specific feature
  "bugfix/JIRA-ID-description" for bug fixing
  "release/version" as necessary for pushing fixes outside of mainline development to a released version


* CONFIGURATIONS

The config/configurations directory has configuration files that will be used when run in a Docker container.
These files include, for instance, default user accounts and database connection information.
There would typically be local (developer workstation), qa, and production configurations.
Files common to multiple configurations can be placed in the config/configurations/default directory;
these can be overridden by files in the specific configuration directory.

To run the application on a Tomcat server without Docker, create your own set of config files using
the configurations ones as a starting point.  For local use, place your context.xml in src/main/webapp/META-INF
but do NOT check it in to version control.


* DOCKER BUILD AND DEPLOY

Maven + Docker build:
  mvn clean package dockerfile:build

Tag the build with date and branch:
  docker tag dockerreg.cast.org/skeleton dockerreg.cast.org/skeleton:developYYYYMMDD
  docker tag dockerreg.cast.org/skeleton dockerreg.cast.org/skeleton:masterYYYYMMDD

Push to registry:
  docker push $!

The Docker run command will need to include the configuration to use as well as port mapping,
something like:

docker run -p80:8080 -e "APP_CONFIG=local" dockerreg.cast.org/skeleton

Scripts to run various CAST apps are stored in git:
	https://bitbucket.cast.org/projects/DOC/repos/docker/browse


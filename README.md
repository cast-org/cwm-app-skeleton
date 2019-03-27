# Cast-Wicket-Modules Skeleton application

This application demonstrates basic setup needed to use some of the basic infrastructure 
that the 
[CAST Wicket Modules](https://github.com/cast-org/cast-wicket-modules)
provide:
 * Base database structure
 * Event logging

## Build and deployment instructions

### Configurations

The `config/configurations` directory has configuration files that will be used when run in a Docker container.
These files include, for instance, default user accounts and database connection information.
There would typically be `local` (developer workstation), `qa`, and `prod` (production) configurations.
Files common to multiple configurations can be placed in the `config/configurations/default` directory;
these can be overridden by files in the specific configuration directory.

### Run in Tomcat

To run the application on a Tomcat server without Docker, 
create a set of config files using the `configurations` ones as a starting
point.  Place context.xml in `$TOMCAT_HOME/conf/catalina/localhost`, 
have it point to the location of `app.config`, and have `app.config` point
to the other files and directories needed.
 
For development use, place your `context.xml` in `src/main/webapp/META-INF`
but do _not_ check it in to version control.


### Build and run Docker container

Maven + Docker build:

`mvn clean package dockerfile:build`

The Docker run command will need to include the configuration to use as well as port mapping,
something like:

`docker run -p80:8080 -e "APP_CONFIG=local" skeleton`




FROM payara/server-full:6.2023.12

# Copy PostgreSQL driver to the correct lib directory
COPY target/postgresql.jar /opt/payara/appserver/glassfish/domains/domain1/lib/

# Copy WAR to autodeploy directory
COPY target/cargo-tracker.war /opt/payara/appserver/glassfish/domains/domain1/autodeploy/

EXPOSE 8080 4848

# Start domain in verbose mode
CMD ["asadmin", "start-domain", "-v", "domain1"]
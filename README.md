# osgi-rdm-services
Reference Data Management Services using OSGi and Apache  Camel EIP

# Install wb-lib-generic-repository
JBossFuse:karaf@root> install mvn:com.scb.wb/wb-lib-generic-repository/1.0.0

# Install wb-rdm-repository
JBossFuse:karaf@root> install mvn:com.scb.rdm/wb-rdm-repository/1.0.0

# Install wb-rdm-rest for Rest APIs
JBossFuse:karaf@root> install mvn:com.scb.rdm/wb-rdm-rest/1.0.0

# Check if all the bundles have been successfully installed
[ 295] [Active     ] [            ] [       ] [   60] Generic Repository (1.0.0)
[ 296] [Active     ] [Created     ] [       ] [   60] WB Reference Data Management Repository (1.0.0
)
[ 300] [Active     ] [Created     ] [       ] [   60] Reference Data Management REST API (1.0.0)

# Below endpoints can be invoked from REST Client to verify the REST services
http://<hostname>:8181/cxf/rdm/countryCode
http://<hostname>:8181/cxf/rdm/countryCode/{id}
http://<hostname>:8181/cxf/rdm/currencyCode
http://<hostname>:8181/cxf/rdm/currencyCode/{id}
http://<hostname>:8181/cxf/rdm/standardCode/getCustomerSegmentCode
http://<hostname>:8181/cxf/rdm/standardCode/getCustomerSubSegmentCode
http://<hostname>:8181/cxf/rdm/standardCode/getCustomerIsicCode
http://<hostname>:8181/cxf/rdm/standardCode/getCustomerLegalConstitutionCode
http://<hostname>:8181/cxf/rdm/standardCode/getCustomerBaselSegmentCode
http://<hostname>:8181/cxf/rdm/standardCode/getCustomerBaselSubSegmentCode


# wb-rdm-workflow
Reference Data Management Workflow using OSGi and Apache Camel EIP

# Dependencies for wb-rdm-workflow
JBossFuse:karaf@root> install wrap:mvn:com.scb.edmi/metadata-xml-binding/trunk-SNAPSHOT
JBossFuse:karaf@root> install wrap:mvn:com.scb.rdm/rdm-country-jaxb/trunk-SNAPSHOT
JBossFuse:karaf@root> install wrap:mvn:com.scb.rdm/rdm-currency-jaxb/trunk-SNAPSHOT
JBossFuse:karaf@root> install wrap:mvn:com.scb.rdm/rdm-standardcodes-jaxb/trunk-SNAPSHOT
JBossFuse:karaf@root> install mvn:com.scb.wb/wb-lib-generic-repository/1.0.0
JBossFuse:karaf@root> install mvn:com.scb.rdm/wb-rdm-repository/1.0.0
JBossFuse:karaf@root> install mvn:com.scb.rdm/wb-rdm-workflow/1.0.0


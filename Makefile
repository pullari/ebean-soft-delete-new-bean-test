test:
	gradle -Pprofile=17.11.0 clean test
	gradle -Pprofile=17.11.1 clean test || true
	gradle -Pprofile=19.6.0 clean test

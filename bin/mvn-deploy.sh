#!/bin/bash
mvn clean deploy -Dmaven.test.skip=true -Pdeploy -P$1
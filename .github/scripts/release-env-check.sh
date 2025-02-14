#!/usr/bin/env bash

echo "Checking repository [$GITHUB_REPOSITORY]..."
[[ "${GITHUB_REPOSITORY}" != "tinkoff-mobile-tech/droidherd-fork" ]] && exit 1

echo "Checking that ref type is tag ..."
[[ "${GITHUB_REF_TYPE}" != "tag" ]] && exit 1

echo "Checking tag [$GITHUB_REF_NAME]..."
[[ "${GITHUB_REF_NAME}" =~ ^release-[0-9]+\.[0-9]+\.[0-9]+$ ]] || exit 1

echo "Ok, lets go"

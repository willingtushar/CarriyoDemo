package com.carriyo.carriyodemo.utils

abstract class ValidationException(override val message: String, open val fieldName: String) : Exception(message)

class MissingCommunicationAddressTagException : ValidationException("Missing communication tag in address", "missingCommunicationTag")
class MultipleCommunicationAddressException : ValidationException("Only one address should be tagged as communication address", "oneThanOneCommunicationTag")
class MultipleHomeAddressException : ValidationException("Multiple home address in the request", "multipleHomeAddress")
class MultipleWorkAddressException : ValidationException("Multiple work address in the request", "multipleWorkAddress")


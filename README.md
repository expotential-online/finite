# Introduction

## Why Finite?

Traditional conditional constructs such as if-else and switch are fundamental building blocks of control flow in most programming languages. Their usage is typically clear, concise and easily comprehensible by programmers familiar with any language.

Despite their ubiquity, these constructs have some inadequacies in certain circumstances and when considered from certain points of view. Specifically, for JVM languages:

1. Both constructs permit "default" behaviour for cases which have not specifically been accounted for. 
2. 

## Some alternative approaches

### "Rich" enums

Consider an enum where each value corresponds to some string. One way to map each enum value to its corresponding string might be with a switch statement. 

## Terminology

| Term              | Meaning                                                                                                                                                                                                                                                                   |
|-------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Space             | A named set of values of a particular type equipped with a way of describing those values in a human-readable way                                                                                                                                                         |
| Finite space      | A space whose set of values is "practically" finite. For example, boolean and enum types. By contrast, the values the double type can represent are bound by their finite bit representation but encompass such a huge range they are not considered "practically" finite |
| Item describer    | A function to derive human-readable descriptions of items from a space                                                                                                                                                                                                    |
| Mapper            | A mapping from one or more finite spaces to another (possibly non-finite) space                                                                                                                                                                                           |
| Mapper definition | A recipe for building a mapper including details of domain and range spaces, what is mapped to what and what is explicitly not mapped                                                                                                                                     |
| Mapper builder    | A factory for building a mapper of a certain type. New implementations typically extend from an abstract class                                                                                                                                                            |

# Mappers

## Introduction

A mapper defines a translation between one or more finite spaces and another (possibly non-finite space) 

## Implementing a New Mapping

New mappings are introduced by extending one of the abstract builder classes. For example:

* AbstractEnumMapperBuilder
* AbstractNonEnumMapperBuilder

You must implement a single abstract method, which takes as an argument a _definition starter_ which is effectively a builder that you can direct with fluent method calls to flesh out the details of your mapping and the spaces involved.

# Enforcement

One of the reasons the existence of Finite is that JVM language compilers are typically incapable of policing certain _informal_ contracts. In particular, it cannot police the requirement that every value in the domain space of a mapping either corresponds to a value in the range space, or is equipped with an explicitly stated reason for not having a mapping.

Trying to enforce such contracts at run-time is also sub-optimal. You'd rather not realise you missed something through a production outage.

That is why Finite provides machinery to police adherence to contracts at test-time. By constructing a single unit test and applying the machinery to one or more package trees, it can detect and validate every defined mapping and fail with a full inventory or any problems.

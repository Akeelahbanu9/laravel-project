<template>
    <Head title="Student" />

    <AuthenticatedLayout>
        <template #header>
            <h2 class="font-semibold text-xl text-gray-800 leading-tight">
                Student Edit
            </h2>
        </template>

        <div class="py-12">
            <div class="max-w-7xl mx-auto sm:px-6 lg:px-8 space-y-6">
                <div class="p-4 sm:p-8 bg-white shadow sm:rounded-lg">
                    <div class="container mx-auto">
                        <form
                            class="max-w-md mx-auto"
                            @submit.prevent="
                                form.post(`/student/${student.id}`)
                            "
                        >
                            <div class="relative z-0 w-full mb-5 group">
                                <label
                                    for="student_id"
                                    class="block text-sm font-medium leading-6 text-gray-900"
                                    >Student ID</label
                                >
                                <div
                                    class="text-red-600"
                                    v-if="form.errors.student_id"
                                >
                                    {{ form.errors.student_id }}
                                </div>
                                <input
                                    type="text"
                                    name="student_id"
                                    v-model="form.student_id"
                                    class="block w-full rounded-md py-1.5 pl-7 pr-20 text-gray-900 border-gray-200"
                                    required
                                />
                            </div>

                            <div class="relative z-0 w-full mb-5 group">
                                <label
                                    for="name"
                                    class="block text-sm font-medium leading-6 text-gray-900"
                                    >Name</label
                                >
                                <div
                                    class="text-red-600"
                                    v-if="form.errors.name"
                                >
                                    {{ form.errors.name }}
                                </div>
                                <input
                                    type="text"
                                    name="name"
                                    v-model="form.name"
                                    class="block w-full rounded-md py-1.5 pl-7 pr-20 text-gray-900 border-gray-200"
                                    required
                                />
                            </div>
                            <div class="relative z-0 w-full mb-5 group">
                                <label
                                    for="image"
                                    class="block text-sm font-medium leading-6 text-gray-900"
                                    >Change Image</label
                                >
                                <input
                                    type="file"
                                    name="image"
                                    @input="form.image = $event.target.files[0]"
                                    class="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 focus:outline-none"
                                />
                            </div>
                            <div class="relative z-0 w-full mb-5 group">
                                <label
                                    for="age"
                                    class="block text-sm font-medium leading-6 text-gray-900"
                                    >Age</label
                                >
                                <div
                                    class="text-red-600"
                                    v-if="form.errors.age"
                                >
                                    {{ form.errors.age }}
                                </div>
                                <input
                                    type="text"
                                    name="age"
                                    v-model="form.age"
                                    class="block w-full rounded-md py-1.5 pl-7 pr-20 text-gray-900 border-gray-200"
                                    required
                                />
                            </div>
                            <div class="relative z-0 w-full mb-5 group">
                                <label
                                    for="name"
                                    class="block text-sm font-medium leading-6 text-gray-900"
                                    >Status</label
                                >
                                <input
                                    type="checkbox"
                                    name="name"
                                    :true-value="1"
                                    :false-value="0"
                                    v-model="form.status"
                                    class="block rounded-md border-gray-200"
                                />
                            </div>

                            <div class="flex justify-center items-center">
                                <button
                                    type="submit"
                                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
                                >
                                    Update
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </AuthenticatedLayout>
</template>

<script setup>
import AuthenticatedLayout from "@/Layouts/AuthenticatedLayout.vue";
import { Head, Link, useForm } from "@inertiajs/vue3";
import { defineProps } from "vue";

let props = defineProps({
    student: Object,
    errors: Object,
});

const form = useForm({
    student_id: props.student.student_id,
    name: props.student.name,
    age: props.student.age,
    image: "",
    status: props.student.status,
    _method: "PUT",
});
</script>

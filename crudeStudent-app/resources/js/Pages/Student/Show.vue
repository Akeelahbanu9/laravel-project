<script setup>
import AuthenticatedLayout from "@/Layouts/AuthenticatedLayout.vue";
import { Head, Link } from "@inertiajs/vue3";

defineProps({
    student: Object,
});
</script>

<template>
    <Head title="Student " />

    <AuthenticatedLayout>
        <template #header>
            <h2 class="font-semibold text-xl text-gray-800 leading-tight">
                Student Details
            </h2>
        </template>

        <div class="py-12">
            <div class="max-w-7xl mx-auto sm:px-6 lg:px-8 space-y-6">
                <div class="p-4 sm:p-8 bg-white shadow sm:rounded-lg">
                    <div class="container mx-auto">
                        <div
                            v-if="$page.props.message"
                            class="p-4 mb-4 text-sm text-green-800 rounded-lg bg-green-50 dark:bg-gray-800 dark:text-green-400"
                            role="alert"
                        >
                            <span class="font-medium">Success!</span>
                            {{ $page.props.message }}
                        </div>

                        <div class="flex justify-center items-center h-full">
                            <div
                                class="bg-white shadow-md rounded-lg overflow-hidden max-w-md w-full"
                            >
                                <div
                                    class="bg-gray-200 px-4 py-3 border-b border-gray-300"
                                >
                                    <h2
                                        class="text-lg font-semibold text-gray-800"
                                    >
                                        {{ student.name }}
                                    </h2>
                                </div>

                                <div class="px-4 py-3">
                                    <div class="mb-2">
                                        <label
                                            class="block text-gray-700 text-sm font-bold mb-1"
                                            >Student ID:</label
                                        >
                                        <p class="text-gray-900">
                                            {{ student.student_id }}
                                        </p>
                                    </div>

                                    <div class="mb-2">
                                        <label
                                            class="block text-gray-700 text-sm font-bold mb-1"
                                            >Age:</label
                                        >
                                        <p class="text-gray-900">
                                            {{ student.age }}
                                        </p>
                                    </div>

                                    <div class="mb-2">
                                        <label
                                            class="block text-gray-700 text-sm font-bold mb-1"
                                            >Status:</label
                                        >
                                        <span
                                            v-if="student.status"
                                            class="bg-green-100 text-green-800 text-xs font-medium me-2 px-2.5 py-0.5 rounded"
                                            >Active</span
                                        >
                                        <span
                                            v-else
                                            class="bg-red-100 text-red-800 text-xs font-medium me-2 px-2.5 py-0.5 rounded"
                                            >Inactive</span
                                        >
                                    </div>

                                    <div class="mb-2">
                                        <label
                                            class="block text-gray-700 text-sm font-bold mb-1"
                                            >Image:</label
                                        >
                                        <img
                                            :src="student.image"
                                            alt=""
                                            className="w-full h-64 object-cover"
                                        />
                                    </div>

                                    <Link
                                        :href="
                                            route('student.edit', student.id)
                                        "
                                        class="text-green-500 hover:text-green-700 mr-2"
                                        >Edit</Link
                                    >
                                    <Link
                                        :href="
                                            route('student.destroy', student.id)
                                        "
                                        method="DELETE"
                                        class="text-red-500 hover:text-red-700 mr-2"
                                        >Delete</Link
                                    >
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </AuthenticatedLayout>
</template>

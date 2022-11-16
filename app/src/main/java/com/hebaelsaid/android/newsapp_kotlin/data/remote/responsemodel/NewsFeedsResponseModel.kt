package com.hebaelsaid.android.newsapp_kotlin.data.remote.responsemodel

data class NewsFeedsResponseModel(
    val `data`: Data?,
    val kind: String? // Listing
) {
    data class Data(
        val after: String?, // t3_yqsd0g
        val before: String?, // null
        val children: List<Children?>?,
        val dist: Int?, // 25
        val geo_filter: String?, // null
        val modhash: String?
    ) {
        data class Children(
            val `data`: Data?,
            val kind: String? // t3
        ) {
            data class Data(
                val all_awardings: List<AllAwarding?>?,
                val allow_live_comments: Boolean?, // false
                val approved_at_utc: String?, // null
                val approved_by: String?, // null
                val archived: Boolean?, // false
                val author: String?, // Top_Engineering_4191
                val author_flair_background_color: String?, // null
                val author_flair_css_class: String?, // null
                val author_flair_richtext: List<String?>?,
                val author_flair_template_id: String?, // null
                val author_flair_text: String?, // null
                val author_flair_text_color: String?, // null
                val author_flair_type: String?, // text
                val author_fullname: String?, // t2_c25y4ifs
                val author_is_blocked: Boolean?, // false
                val author_patreon_flair: Boolean?, // false
                val author_premium: Boolean?, // false
                val awarders: List<String?>?,
                val banned_at_utc: String?, // null
                val banned_by: String?, // null
                val can_gild: Boolean?, // false
                val can_mod_post: Boolean?, // false
                val category: String?, // null
                val clicked: Boolean?, // false
                val content_categories: String?, // null
                val contest_mode: Boolean?, // false
                val created: Double?, // 1668378633.0
                val created_utc: Double?, // 1668378633.0
                val discussion_type: String?, // null
                val distinguished: String?, // null
                val domain: String?, // self.Kotlin
                val downs: Int?, // 0
                val edited: Any?, // 1668378453.0
                val gilded: Int?, // 0
                val gildings: Gildings?,
                val hidden: Boolean?, // false
                val hide_score: Boolean?, // false
                val id: String?, // yugrb2
                val is_created_from_ads_ui: Boolean?, // false
                val is_crosspostable: Boolean?, // false
                val is_meta: Boolean?, // false
                val is_original_content: Boolean?, // false
                val is_reddit_media_domain: Boolean?, // false
                val is_robot_indexable: Boolean?, // true
                val is_self: Boolean?, // true
                val is_video: Boolean?, // false
                val likes: String?, // null
                val link_flair_background_color: String?,
                val link_flair_css_class: String?, // null
                val link_flair_richtext: List<String?>?,
                val link_flair_text: String?, // null
                val link_flair_text_color: String?, // dark
                val link_flair_type: String?, // text
                val locked: Boolean?, // false
                val media: Media?,
                val media_embed: MediaEmbed?,
                val media_metadata: MediaMetadata?,
                val media_only: Boolean?, // false
                val mod_note: String?, // null
                val mod_reason_by: String?, // null
                val mod_reason_title: String?, // null
                val mod_reports: List<String?>?,
                val name: String?, // t3_yugrb2
                val no_follow: Boolean?, // false
                val num_comments: Int?, // 15
                val num_crossposts: Int?, // 0
                val num_reports: String?, // null
                val over_18: Boolean?, // false
                val parent_whitelist_status: String?, // all_ads
                val permalink: String?, // /r/Kotlin/comments/yugrb2/kotlin_and_java_loom_will_kotlin_benefit_from/
                val pinned: Boolean?, // false
                val pwls: Int?, // 6
                val quarantine: Boolean?, // false
                val removal_reason: String?, // null
                val removed_by: String?, // null
                val removed_by_category: String?, // null
                val report_reasons: String?, // null
                val saved: Boolean?, // false
                val score: Int?, // 23
                val secure_media: SecureMedia?,
                val secure_media_embed: SecureMediaEmbed?,
                val selftext: String?,
                val selftext_html: String?, // &lt;!-- SC_OFF --&gt;&lt;div class="md"&gt;&lt;p&gt;I am learning C Interop with Kotlin Native. I successfully imported my sample C program using &lt;strong&gt;.Def&lt;/strong&gt;file and executed the code in kotlin&lt;/p&gt;&lt;p&gt;So, I am thinking about import GTK4 libs, which is in C, to Kotlin/Native project and try a GTK app there&lt;/p&gt;&lt;p&gt;But since GTK4 have lot of header files and linking libs, I don&amp;#39;t know how to import them&lt;/p&gt;&lt;p&gt;I successfully executed GTK4 sample program in CLion C++ project.&lt;/p&gt;&lt;p&gt;But need to know how to import the GTK4 libs and headers to Kotlin/Native project&lt;/p&gt;&lt;p&gt;My Cmake in Clion project&lt;/p&gt;&lt;pre&gt;&lt;code&gt;cmake_minimum_required(VERSION 3.24)project(HexEditor)set(CMAKE_CXX_STANDARD 20)find_package(PkgConfig REQUIRED)pkg_check_modules(GTK4 REQUIRED gtk4)include_directories(${GTK4_INCLUDE_DIRS})link_directories(${GTK4_LIBRARY_DIRS})add_definitions(${GTK4_CFLAGS_OTHER})add_executable(HexEditor main.cpp)target_link_libraries(HexEditor ${GTK4_LIBRARIES})&lt;/code&gt;&lt;/pre&gt;&lt;p&gt;How to map them in &lt;strong&gt;.def&lt;/strong&gt;file of Kotlin/Native ?&lt;/p&gt;&lt;/div&gt;&lt;!-- SC_ON --&gt;
                val send_replies: Boolean?, // true
                val spoiler: Boolean?, // false
                val stickied: Boolean?, // false
                val subreddit: String?, // Kotlin
                val subreddit_id: String?, // t5_2so2r
                val subreddit_name_prefixed: String?, // r/Kotlin
                val subreddit_subscribers: Int?, // 64726
                val subreddit_type: String?, // public
                val suggested_sort: String?, // null
                val thumbnail: String?,
                val title: String?, // Kotlin and Java Loom. Will Kotlin benefit from virtual threads?
                val top_awarded_type: String?, // null
                val total_awards_received: Int?, // 0
                val treatment_tags: List<String?>?,
                val ups: Int?, // 23
                val upvote_ratio: Double?, // 0.9
                val url: String?, // https://www.reddit.com/r/Kotlin/comments/yugrb2/kotlin_and_java_loom_will_kotlin_benefit_from/
                val url_overridden_by_dest: String?, // https://www.infoq.com/news/2022/11/meta-port-java-kotlin/
                val user_reports: List<String?>?,
                val view_count: String?, // null
                val visited: Boolean?, // false
                val whitelist_status: String?, // all_ads
                val wls: Int? // 6
            ) {
                data class AllAwarding(
                    val award_sub_type: String?, // GLOBAL
                    val award_type: String?, // global
                    val awardings_required_to_grant_benefits: String?, // null
                    val coin_price: Int?, // 150
                    val coin_reward: Int?, // 0
                    val count: Int?, // 1
                    val days_of_drip_extension: String?, // null
                    val days_of_premium: String?, // null
                    val description: String?, // Thank you stranger. Shows the award.
                    val end_date: String?, // null
                    val giver_coin_reward: String?, // null
                    val icon_format: String?, // PNG
                    val icon_height: Int?, // 2048
                    val icon_url: String?, // https://i.redd.it/award_images/t5_22cerq/klvxk1wggfd41_Helpful.png
                    val icon_width: Int?, // 2048
                    val id: String?, // award_f44611f1-b89e-46dc-97fe-892280b13b82
                    val is_enabled: Boolean?, // true
                    val is_new: Boolean?, // false
                    val name: String?, // Helpful
                    val penny_donate: String?, // null
                    val penny_price: Int?, // 0
                    val resized_icons: List<ResizedIcon?>?,
                    val resized_static_icons: List<ResizedStaticIcon?>?,
                    val start_date: String?, // null
                    val static_icon_height: Int?, // 2048
                    val static_icon_url: String?, // https://i.redd.it/award_images/t5_22cerq/klvxk1wggfd41_Helpful.png
                    val static_icon_width: Int?, // 2048
                    val sticky_duration_seconds: String?, // null
                    val subreddit_coin_reward: Int?, // 0
                    val subreddit_id: String?, // null
                    val tiers_by_required_awardings: String? // null
                ) {
                    data class ResizedIcon(
                        val height: Int?, // 16
                        val url: String?, // https://preview.redd.it/award_images/t5_22cerq/klvxk1wggfd41_Helpful.png?width=16&amp;height=16&amp;auto=webp&amp;s=a5662dfbdb402bf67866c050aa76c31c147c2f45
                        val width: Int? // 16
                    )

                    data class ResizedStaticIcon(
                        val height: Int?, // 16
                        val url: String?, // https://preview.redd.it/award_images/t5_22cerq/klvxk1wggfd41_Helpful.png?width=16&amp;height=16&amp;auto=webp&amp;s=a5662dfbdb402bf67866c050aa76c31c147c2f45
                        val width: Int? // 16
                    )
                }

                class Gildings

                data class Media(
                    val oembed: Oembed?,
                    val type: String? // youtube.com
                ) {
                    data class Oembed(
                        val author_name: String?, // Refactoring to Kotlin with Duncan McGregor
                        val author_url: String?, // https://www.youtube.com/c/DuncanMcGregors
                        val height: Int?, // 200
                        val html: String?, // &lt;iframe width="356" height="200" src="https://www.youtube.com/embed/kkV1lfUjJao?feature=oembed&amp;enablejsapi=1" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen title="Mocking framework authors hate it when you use this one weird trick"&gt;&lt;/iframe&gt;
                        val provider_name: String?, // YouTube
                        val provider_url: String?, // https://www.youtube.com/
                        val thumbnail_height: Int?, // 360
                        val thumbnail_url: String?, // https://i.ytimg.com/vi/kkV1lfUjJao/hqdefault.jpg
                        val thumbnail_width: Int?, // 480
                        val title: String?, // Mocking framework authors hate it when you use this one weird trick
                        val type: String?, // video
                        val version: String?, // 1.0
                        val width: Int? // 356
                    )
                }

                data class MediaEmbed(
                    val content: String?, // &lt;iframe width="356" height="200" src="https://www.youtube.com/embed/kkV1lfUjJao?feature=oembed&amp;enablejsapi=1" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen title="Mocking framework authors hate it when you use this one weird trick"&gt;&lt;/iframe&gt;
                    val height: Int?, // 200
                    val scrolling: Boolean?, // false
                    val width: Int? // 356
                )

                data class MediaMetadata(
                    val `5sfq57litqz91`: Sfq57litqz91?
                ) {
                    data class Sfq57litqz91(
                        val e: String?, // Image
                        val id: String?, // 5sfq57litqz91
                        val m: String?, // image/png
                        val p: List<P?>?,
                        val s: S?,
                        val status: String? // valid
                    ) {
                        data class P(
                            val u: String?, // https://preview.redd.it/5sfq57litqz91.png?width=108&amp;crop=smart&amp;auto=webp&amp;s=e25c6ec98040d3603328805cffc098c9e3c03d34
                            val x: Int?, // 108
                            val y: Int? // 56
                        )

                        data class S(
                            val u: String?, // https://preview.redd.it/5sfq57litqz91.png?width=2544&amp;format=png&amp;auto=webp&amp;s=8f29e4c97b67161668bec472f29ffebcaeb79e84
                            val x: Int?, // 2544
                            val y: Int? // 1335
                        )
                    }
                }

                data class SecureMedia(
                    val oembed: Oembed?,
                    val type: String? // youtube.com
                ) {
                    data class Oembed(
                        val author_name: String?, // Refactoring to Kotlin with Duncan McGregor
                        val author_url: String?, // https://www.youtube.com/c/DuncanMcGregors
                        val height: Int?, // 200
                        val html: String?, // &lt;iframe width="356" height="200" src="https://www.youtube.com/embed/kkV1lfUjJao?feature=oembed&amp;enablejsapi=1" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen title="Mocking framework authors hate it when you use this one weird trick"&gt;&lt;/iframe&gt;
                        val provider_name: String?, // YouTube
                        val provider_url: String?, // https://www.youtube.com/
                        val thumbnail_height: Int?, // 360
                        val thumbnail_url: String?, // https://i.ytimg.com/vi/kkV1lfUjJao/hqdefault.jpg
                        val thumbnail_width: Int?, // 480
                        val title: String?, // Mocking framework authors hate it when you use this one weird trick
                        val type: String?, // video
                        val version: String?, // 1.0
                        val width: Int? // 356
                    )
                }

                data class SecureMediaEmbed(
                    val content: String?, // &lt;iframe width="356" height="200" src="https://www.youtube.com/embed/kkV1lfUjJao?feature=oembed&amp;enablejsapi=1" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen title="Mocking framework authors hate it when you use this one weird trick"&gt;&lt;/iframe&gt;
                    val height: Int?, // 200
                    val media_domain_url: String?, // https://www.redditmedia.com/mediaembed/ysfqby
                    val scrolling: Boolean?, // false
                    val width: Int? // 356
                )
            }
        }
    }
}